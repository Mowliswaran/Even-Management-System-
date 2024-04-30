package user_interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Event_table.Event;
import Event_table.Participant;
import Event_table.Registration;
import Event_table.Venue;
import services.EventService;
import services.ParticipantService;
import services.RegisterService;
import services.VenueService;

public class UserInterface {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException {
        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        RegisterService registrationService = new RegisterService();
        VenueService venueService = new VenueService();
        displayMenu(eventService,participantService,registrationService,venueService);
    }

    private static void displayMenu(EventService eventService, ParticipantService participantService,RegisterService registrationService,VenueService venueService) throws ClassNotFoundException {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. View All Events");
            System.out.println("2. Add New Event");
            System.out.println("3. Update Event");
            System.out.println("4. Delete Event");
            System.out.println("5. View All Participants");
            System.out.println("6. Add New Participants");
            System.out.println("7. Update Participants");
            System.out.println("8. Delete Participants");
            System.out.println("9. View All Registrations");
            System.out.println("10. Add New Registrations");
            System.out.println("11. Update Registrations");
            System.out.println("12. Delete Registrations");
            System.out.println("13. View All Venues");
            System.out.println("14. Add New Venues");
            System.out.println("15. Update Venues");
            System.out.println("16. Delete Venues");
            System.out.println("17. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    viewAllEvents(eventService);
                    break;
                case 2:
                    addEvent(eventService);
                    break;
                case 3:
                    updateEvent(eventService);
                    break;
                case 4:
                    deleteEvent(eventService);
                    break;
                case 5:
                	viewAllParticipants(participantService);
                	
                    break;
                case 6:
                	addParticipant(participantService);
                    break;
                case 7:
                    updateParticipant(participantService);
                    break;
                case 8:
                    deleteParticipant(participantService);
                    break;
                case 9:
                	viewAllRegistrations(registrationService);
                	
                    break;
                case 10:
                	addRegistration(registrationService);
                    break;
                case 11:
                    updateRegistration(registrationService);
                    break;
                case 12:
                    deleteRegistration(registrationService);
                    break;
                case 13:
                	viewAllVenues(venueService);
                	
                    break;
                case 14:
                	addVenue(venueService);
                    break;
                case 15:
                    updateVenue(venueService);
                    break;
                case 16:
                    deleteVenue(venueService);
                    break;
                case 17:
                    System.err.println("exiting");
                    break;
           
                    }
        } while (choice != 17);
    }

    private static void viewAllEvents(EventService eventService) throws ClassNotFoundException {
        System.out.println("\nAll Events:");
        List<Event> events = eventService.getallevent();
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private static void addEvent(EventService eventService) throws ClassNotFoundException {
        System.out.println("\nAdding a new event...");
        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Event name: ");
        String name = sc.nextLine();
        System.out.print("Enter Event Date (yyyy-MM-dd): ");
        java.util.Date date = getDateInput();
        Event newEvent = new Event(id, name, date);
        eventService.addevent(newEvent);
    }

    private static void updateEvent(EventService eventService) throws ClassNotFoundException {
        System.out.println("\nUpdating an event...");
        System.out.print("Enter Event ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Event name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Event Date (yyyy-MM-dd): ");
        java.util.Date date = getDateInput();
        Event updatedEvent = new Event(id, name, date);
        eventService.updateevent(updatedEvent);
    }

    private static void deleteEvent(EventService eventService) throws ClassNotFoundException {
        System.out.println("\nDeleting an event...");
        System.out.print("Enter Event ID to delete: ");
        int id = sc.nextInt();
        eventService.deleteevent(id);
        System.out.println("Event deleted successfully.");
    }

       private static void viewAllParticipants(ParticipantService participantService) throws ClassNotFoundException {
        System.out.println("\nAll Participants:");
        List<Participant> participants = participantService.getallparticipant();
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }

    private static void addParticipant(ParticipantService participantService) throws ClassNotFoundException {
        System.out.println("\nAdding a new participant...");
        System.out.print("Enter Participant ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Participant name: ");
        String name = sc.nextLine();
        System.out.print("Enter Participant email: ");
        String email = sc.nextLine();
        System.out.print("Enter Participant Phone no: ");
        int ph_no = sc.nextInt();
        sc.nextLine();
        Participant newParticipant = new Participant(id, name, email, ph_no);
        participantService.addParticipant(newParticipant);
    }

    private static void updateParticipant(ParticipantService participantService) throws ClassNotFoundException {
        System.out.println("\nUpdating an participant...");
        System.out.print("Enter Participant ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Participant name: ");
        String name = sc.nextLine();
        System.out.print("Enter Participant email: ");
        String email = sc.nextLine();
        System.out.print("Enter Participant Phone no: ");
        int ph_no = sc.nextInt();
//        sc.nextLine();
        Participant newParticipant = new Participant(id, name, email, ph_no);
        participantService.updateparticipant(newParticipant);
    }

    private static void deleteParticipant(ParticipantService participantService) throws ClassNotFoundException {
        System.out.println("\nDeleting an participant...");
        System.out.print("Enter Participant ID to delete: ");
        int id = sc.nextInt();
        participantService.deleteparticipant(id);
        System.out.println("Participant deleted successfully.");
    }
    private static void viewAllRegistrations(RegisterService registrationService) throws ClassNotFoundException {
        System.out.println("\nAll Registrations:");
        List<Registration> registrations = registrationService.getallregistration();
        for (Registration registration : registrations) {
            System.out.println(registration);
        }
    }

    private static void addRegistration(RegisterService registrationService) throws ClassNotFoundException {
        System.out.println("\nAdding a new registration...");
        System.out.print("Enter Registration ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Event ID: ");
        int event_id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Participant ID: ");
        int participant_id = sc.nextInt();
//        sc.nextLine();
        System.out.print("Enter Event Date (yyyy-MM-dd): ");
        java.util.Date date = getDateInput();
        Registration newRegistration = new Registration(id, event_id,participant_id, date);
        registrationService.addregistration(newRegistration);
    }

    private static void updateRegistration(RegisterService registrationService) throws ClassNotFoundException {
        System.out.println("\nUpdating an registration...");
        System.out.print("Enter Registration ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Event ID: ");
        int event_id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Participant ID: ");
        int participant_id = sc.nextInt();
//        sc.nextLine();
        System.out.print("Enter Event Date (yyyy-MM-dd): ");
        java.util.Date date = getDateInput();
        Registration newRegistration = new Registration(id, event_id,participant_id, date);
        registrationService.updateregistration(newRegistration);
        
    }

    private static void deleteRegistration(RegisterService registrationService) throws ClassNotFoundException {
        System.out.println("\nDeleting an event...");
        System.out.print("Enter Registration ID to delete: ");
        int id = sc.nextInt();
        registrationService.deleteregistration(id);
        System.out.println("Registration deleted successfully.");
    }

    private static java.util.Date getDateInput() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            try {
                String dateStr = sc.next();
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
    }
    private static void viewAllVenues(VenueService venueService) throws ClassNotFoundException {
        System.out.println("\nAll Venues:");
        List<Venue> venues = venueService.getallvenue();
        for (Venue venue : venues) {
            System.out.println(venue);
        }
    }

    private static void addVenue(VenueService venueService) throws ClassNotFoundException {
        System.out.println("\nAdding a new venue...");
        System.out.print("Enter venue ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter venue name: ");
        String name = sc.nextLine();
        System.out.print("Enter venue address: ");
        String address = sc.nextLine();
        System.out.print("Enter venue capacity: ");
        int capacity = sc.nextInt();
//        sc.nextLine();
        Venue newVenue = new Venue(id, name, address, capacity);
        venueService.addVenue(newVenue);
    }

    private static void updateVenue(VenueService venueService) throws ClassNotFoundException {
        System.out.println("\nUpdating an Venue...");
        System.out.print("Enter Venue ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Venue name: ");
        String name = sc.nextLine();
        System.out.print("Enter Venue email: ");
        String address = sc.nextLine();
        System.out.print("Enter Venue Phone no: ");
        int capacity = sc.nextInt();
//        sc.nextLine();
        Venue newVenue = new Venue(id, name, address, capacity);
        venueService.updatevenue(newVenue);
    }

    private static void deleteVenue(VenueService venueService) throws ClassNotFoundException {
        System.out.println("\nDeleting an participant...");
        System.out.print("Enter Participant ID to delete: ");
        int id = sc.nextInt();
        venueService.deletevenue(id);
        System.out.println("Venue deleted successfully.");
    }

}