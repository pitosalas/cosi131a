#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void producer(int pipe_info[])
{
    printf("I am producer\n");
    write(pipe_info[1], "hello", 5);
}

void consumer(int pipe_info[])
{
    printf("I am consumer\n");
    char buffer[100];
    // read(pipe_info[0], buffer, 100);
    // printf("Received: %s\n", buffer);
}

int main()
{
    int pipe_info[2]; // Used to store two ends of first pipe
    int pid1 = fork();
    if (pid1 == 0)
    {
        // Child 1, which will be the consumer
        consumer(pipe_info);
        exit(0);
    }
    else
    {
        int pid2 = fork();
        printf("%d %d", pid1, pid2);
        if (pid2 == 0)
        {
            // Child 2, which will be the producer
            producer(pipe_info);
            exit(0);
        }
    }
    // Parent
    printf("Both children have completed.\n");
    wait(NULL);
    exit(0);
}