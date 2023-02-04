#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    int pid = fork();
    if (pid == 0)
    {
        // Child Only
        printf("             >>> (pid: %o) I am child process\n", getpid());
        exit(0);
    } else {
        // Parent only
        printf("(pid: %o) I am parent process. The new child is pid %o\n", getpid(), pid);  
    }
    wait(NULL);
    printf("(pid: %o) I know that the child has completed.\n", getpid());
    exit(0);
} 