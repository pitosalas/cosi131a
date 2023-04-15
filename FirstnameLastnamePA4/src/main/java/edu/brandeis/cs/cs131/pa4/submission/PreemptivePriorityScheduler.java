package edu.brandeis.cs.cs131.pa4.submission;

import java.util.Collection;

import edu.brandeis.cs.cs131.pa4.scheduler.Scheduler;
import edu.brandeis.cs.cs131.pa4.tunnel.Tunnel;


/**
 * The preemptive priority scheduler assigns vehicles to tunnels based on their priority and supports 
 * preemption with ambulances.
 * It extends the Scheduler class.
 */
public class PreemptivePriorityScheduler extends Scheduler {
	
	public PreemptivePriorityScheduler(String name, Collection<Tunnel> tunnels) {
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

