package edu.brandeis.cs.cs131.pa3.submission;

import java.util.Collection;

import edu.brandeis.cs.cs131.pa3.scheduler.Scheduler;
import edu.brandeis.cs.cs131.pa3.tunnel.Tunnel;
import edu.brandeis.cs.cs131.pa3.tunnel.Vehicle;

/**
 * The priority scheduler assigns vehicles to tunnels based on their priority.
 * It extends the Scheduler class.
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
