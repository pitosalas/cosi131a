package edu.brandeis.cs.cs131.pa4.submission;

import java.util.ArrayList;

import edu.brandeis.cs.cs131.pa4.tunnel.Ambulance;
import edu.brandeis.cs.cs131.pa4.tunnel.Car;
import edu.brandeis.cs.cs131.pa4.tunnel.Direction;
import edu.brandeis.cs.cs131.pa4.tunnel.Sled;
import edu.brandeis.cs.cs131.pa4.tunnel.Tunnel;

/**
 * The BasicTunnel enforces a basic admittance policy. It extends the Tunnel
 * class.
 */
public class PreemptiveTunnel extends BasicTunnel {

	int car_count = 0;
	int sled_count = 0;
	int ambulance_count = 0;
	Direction direction = null;
	ArrayList<Vehicle> inside = new ArrayList<Vehicle>();

	/**
	 * Creates a new instance of a basic tunnel with the given name
	 * 
	 * @param name the name of the basic tunnel
	 */
	public PreemptiveTunnel(String name) {
		super(name);
	}

	@Override
	protected synchronized boolean tryToEnterInner(Vehicle v) {
		if (okCapacity(v) & okType(v) & okDirection(v)) {
			direction = v.getDirection();
			incrementCapacity(v);
			inside.add(v);
			printInTunnel();
			return true;
		}
		System.out.printf("   %s Can't enter tunnel because: %b %b\n", v, okType(v), okDirection(v));
		printInTunnel();
		return false;
	}

	@Override
	protected synchronized void exitTunnelInner(Vehicle vehicle) {
		if (car_count + sled_count + ambulance_count != inside.size()) throw new IllegalStateException("exitTunnelInner");
		if (inside.size() == 0 && direction != null) throw new IllegalStateException("exitTunnelInner");

		if (vehicle instanceof Sled) {
			sled_count--;
			System.out.printf("Sled %s exited tunnel %s\n", vehicle, this);
			inside.remove(vehicle);
			if (sled_count == 0)
				direction = null;
		} else if (vehicle instanceof Car) {
			car_count--;
			System.out.printf("Car %s exited tunnel %s\n", vehicle, this);
			inside.remove(vehicle);
			if (car_count == 0)
				direction = null;
		} else if (vehicle instanceof Ambulance) {
			System.out.printf("Ambulance %s exited tunnel %s\n", vehicle, this);
			ambulance_count--;
			inside.remove(vehicle);

		} else {
			throw new IllegalStateException("exitTunnelInner");
		}
		printInTunnel();
	}

	private boolean okCapacity(Vehicle v) {
		if (v instanceof Sled)
			return sled_count < SLED_CAPACITY;
		else if (v instanceof Car)
			return car_count < CAR_CAPACITY;
		else if (v instanceof Ambulance)
			return ambulance_count == 0;
		else
			throw new IllegalStateException("exitTunnelInner");
	}

	private boolean okType(Vehicle v) {
		if (v instanceof Sled)
			return car_count == 0;
		else if (v instanceof Car)
			return sled_count == 0;
		else if (v instanceof Ambulance)
			return true;
		else
			throw new IllegalStateException("okType");

	}

	private boolean okDirection(Vehicle v) {
		if (direction == null)
			return true;
		else if (v instanceof Ambulance)
			return true;
		else
			return v.getDirection() == direction;
	}

	private void incrementCapacity(Vehicle v) {
		if (v instanceof Sled)
			sled_count++;
		else if (v instanceof Car)
			car_count++;
		else if (v instanceof Ambulance)
			ambulance_count++;		
		else
			throw new IllegalStateException("incrementCapacity");
	}

	private void printInTunnel() {
		System.out.printf("   %s[", getName());
		for (Vehicle v : inside) {
			System.out.printf("%s:", v);
		}
		System.out.println("]");
	}
	
	

}
