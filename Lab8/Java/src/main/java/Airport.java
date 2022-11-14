import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List <? extends Plane> planes;

    public List <PassengerPlane> getPassengerPlanes() {
        List <? extends Plane> planes = this.planes;
        List <PassengerPlane> passengerPlanes = new ArrayList <>();
        for (Plane p : planes) {
            if (p instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) p);
            }
        }
        return passengerPlanes;
    }

    public List <MilitaryPlane> getMilitaryPlanes() {
        List <MilitaryPlane> militaryPlanes = new ArrayList <>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            } else {

            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List <PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }

        return planeWithMaxCapacity;
    }

    public List <MilitaryPlane> getTransportMilitaryPlanes() {
        List <MilitaryPlane> transportMilitaryPlanes = new ArrayList <>();
        List <MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List <MilitaryPlane> getBomberMilitaryPlanes() {
        List <MilitaryPlane> bomberMilitaryPlanes = new ArrayList <>();
        List <MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List <ExperimentalPlane> getExperimentalPlanes() {
        List <ExperimentalPlane> ExperimentalPlanes = new ArrayList <>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                ExperimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return ExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        planes.sort(new Comparator <Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(new Comparator <Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMS() - secondPlane.getMS();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(new Comparator <Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMinLoadCapacity() - secondPlane.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List <? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection <? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List <? extends Plane> planes) {
        this.planes = planes;
    }

}
