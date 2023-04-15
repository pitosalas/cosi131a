package edu.brandeis.cs.cs131.pa4.submission;

import edu.brandeis.cs.cs131.pa4.tunnel.Tunnel;

/**
 * The class for the Preemptive Tunnel, extending Tunnel.
 */
public class PreemptiveTunnel extends Tunnel {
	
	/**
	 * Creates a new instance of a basic tunnel with the given name
	 * @param name the name of the basic tunnel
	 */
	public PreemptiveTunnel(String name) {
		super(name);
	}
	

	@Override
	protected boolean tryToEnterInner(Vehicle vehicle) {
		throw new UnsupportedOperationException("UNIMPLEMENTED");
	}

	@Override
	protected void exitTunnelInner(Vehicle vehicle) {
		throw new UnsupportedOperationException("UNIMPLEMENTED");
	}
	
}
