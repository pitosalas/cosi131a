package edu.brandeis.cs.cs131.pa3.submission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import edu.brandeis.cs.cs131.pa3.scheduler.Scheduler;
import edu.brandeis.cs.cs131.pa3.tunnel.Tunnel;
import edu.brandeis.cs.cs131.pa3.tunnel.Vehicle;

/**
 * The priority scheduler assigns vehicles to tunnels based on their priority.
 * It extends the Scheduler class.
 */
public class PriorityScheduler extends Scheduler {

	private Collection<Tunnel> tunnels;
	private String name;
	ArrayList<Vehicle> waiting = new ArrayList<Vehicle>();
    HashMap<Vehicle, Tunnel> tunnelMap = new HashMap<Vehicle, Tunnel>();

	/**
	 * Creates an instance of a priority scheduler with the given name and tunnels
	 * 
	 * @param name    the name of the priority scheduler
	 * @param tunnels the tunnels where the vehicles will be scheduled to
	 */
	public PriorityScheduler(String name, Collection<Tunnel> tunnels) {
		super(name, tunnels);
		this.name = name;
		this.tunnels = tunnels;
	}

	@Override
	public synchronized Tunnel admit(Vehicle vehicle) {
// Look through each tunnel and see if the vehicle can be admitted
		while (true) {
			Vehicle waiter = getHighestWaitingVehicle();
			if (waiter != null && vehicle.getVehiclePriority() <  waiter.getVehiclePriority()) {
				System.out.printf("%s has to wait because theres a higher priority vehicle %s waiting\n", vehicle, waiter);					
				waiting.add(vehicle);
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (Tunnel t : tunnels) {
				if (t.tryToEnter(vehicle)) {
					System.out.printf(">> admited %s into tunnel %s\n", vehicle, t);
					if (waiting.remove(vehicle)) {
						System.out.printf("*** Removed %s from waiting queue\n",vehicle);
					}
					tunnelMap.put(vehicle, t);
					return t;
				} else {
					System.out.printf("Didn't admit %s into tunnel %s\n", vehicle, t);
				}
			}
// Get here if no tunnel could admit this vehicle
			try {
				System.out.printf("%s has to wait because no queues want to accept him\n", vehicle);					
				waiting.add(vehicle);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void exit(Vehicle vehicle) {
		System.out.printf("<<%s exited tunnel\n", vehicle);
		tunnelMap.get(vehicle).exitTunnel(vehicle);
		tunnelMap.remove(vehicle);
		notifyAll();
	}
	
	private Vehicle getHighestWaitingVehicle() {
		int highestPrio = 0;
		Vehicle highest = null;
		for (Vehicle v: waiting) {
			if (v.getVehiclePriority() > highestPrio) {
				highest = v;
				highestPrio = v.getVehiclePriority();
			}
		}
		return highest;
	}

}
