package avengers;

import java.util.*;

public class EventsAdjacentList {
    private Event[] events;
    private int noOfEvents;

    public EventsAdjacentList(int noOfEvents) {
        this.noOfEvents = noOfEvents;
        this.events = new Event[noOfEvents];
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public void addNeighbor(Event event, Event neighbors) {
        for (int i = 0; i < events.length; i++) {
            if (events[i].getIndex() == event.getIndex()) {
                event.setNeighbors(neighbors);
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < events.length; i++) {
            StdOut.println(events[i].getIndex() + ": " + events[i].getNeighbors());
        }
    }

    public int[] getNoOfPaths(int start, int threshold) {
        int count = 0;
        int euCount = 0;
        int euGreaterOrEqualToThreshold = 0;

        Stack<Integer> nodes = new Stack<>();
        nodes.push(start);
        count += 1;

        while (nodes.size() != 0){
            int current = nodes.pop();
            euCount += (events[start].getWeight());

            for (int i = 0; i < events[current].getNeighbors().size(); i++) {
                nodes.push(events[current].getNeighbors().get(i).getIndex());
                count++;
                if (euCount <= threshold){
                    euGreaterOrEqualToThreshold++;
                }
                euCount += (events[current].getNeighbors().get(i).getWeight());
            }

        }
        int[] total = new int[2];
        total[0] = count;
        total[1] = euGreaterOrEqualToThreshold ;
        return total;
    }
}