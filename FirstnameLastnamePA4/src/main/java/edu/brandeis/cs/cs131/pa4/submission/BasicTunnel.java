package edu.brandeis.cs.cs131.pa4.submission;

import edu.brandeis.cs.cs131.pa4.tunnel.Car;
import edu.brandeis.cs.cs131.pa4.tunnel.Direction;
import edu.brandeis.cs.cs131.pa4.tunnel.Sled;
import edu.brandeis.cs.cs131.pa4.tunnel.Tunnel;


/**
 * The BasicTunnel enforces a basic admittance policy. It extends the Tunnel
 * class.
 */
public class BasicTunnel extends Tunnel {

	int car_count = 0;
	int sled_count = 0;
	Direction direction = null;

	/**
	 * Creates a new instance of a basic tunnel with the given name
	 * 
	 * @param name the name of the basic tunnel
	 */
	public BasicTunnel(String name) {
		super(name);
	}

	@Override
	protected synchronized boolean tryToEnterInner(Vehicle v) {
		if (okCapacity(v) & okType(v) & okDirection(v)) {
			direction = v.getDirection();
			incrementCapacity(v);
			return true;
		}
		return false;
	}

	@Override
	protected synchronized void exitTunnelInner(Vehicle vehicle) {
		if (vehicle instanceof Sled) {
			sled_count--;
			if (sled_count == 0)
				direction = null;
			System.out.printf("Sled %s exited tunnel %s\n", vehicle, this);
		} else if (vehicle instanceof Car) {
			car_count--;
			System.out.printf("Car %s exited tunnel %s\n", vehicle, this);
			if (car_count == 0)
				direction = null;

		} else {
			throw new IllegalStateException("exitTunnelInner");
		}
	}
	
	private boolean okCapacity(Vehicle v) {
		if (v instanceof Sled) 
			return sled_count < SLED_CAPACITY;
		else if (v instanceof Car)
			return car_count < CAR_CAPACITY;
		else
			throw new IllegalStateException("exitTunnelInner");
	}
	
	private boolean okType(Vehicle v) {
		if (v instanceof Sled) 
			return car_count == 0;
		else if (v instanceof Car)
			return sled_count == 0;
		else
			throw new IllegalStateException("exitTunnelInner");

	}

	private boolean okDirection(Vehicle v) {
		if (direction == null)
			return true;
		else return v.getDirection() == direction;	
	}
	
	private void incrementCapacity(Vehicle v) {
		if (v instanceof Sled) 
			sled_count++;
		else if (v instanceof Car)
			car_count++;
		else
			throw new IllegalStateException("exitTunnelInner");

	}
}
