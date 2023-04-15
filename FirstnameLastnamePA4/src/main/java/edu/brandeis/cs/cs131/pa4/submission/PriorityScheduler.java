package edu.brandeis.cs.cs131.pa4.submission;

import java.util.Collection;

import edu.brandeis.cs.cs131.pa4.scheduler.Scheduler;
import edu.brandeis.cs.cs131.pa4.tunnel.Tunnel;

/**
 * The priority scheduler assigns vehicles to tunnels based on their priority
 * It extends the Scheduler class.
 * 
 * You do not need to implement this class for PA4, but copying your solution from PA3
 * may be useful for the PreemptivePriorityScheduler.
 */
public class PriorityScheduler extends Scheduler{
	
	/**
	 * Creates an instance of a priority scheduler with the given name and tunnels
	 * @param name the name of the priority scheduler
	 * @param tunnels the tunnels where the vehicles will be scheduled to
	 */
	public PriorityScheduler(String name, Collection<Tunnel> tunnels) {
		super(name, tunnels);
	}

	@Override
	public Tunnel admit(Vehicle vehicle) {
		throw new UnsupportedOperationException("UNIMPLEMENTED");	
	}
	
	@Override
	public void exit(Vehicle vehicle) {
		throw new UnsupportedOperationException("UNIMPLEMENTED");
	}
	
}
