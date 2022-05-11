import java.util.ArrayList;

public class AppointmentList {

    private ArrayList<Appointment> Ap_List;

    public AppointmentList() {

        Ap_List = new ArrayList<Appointment>();
    }

    public void addToList(CalendarDate c, Employee e) {
        Appointment app = new Appointment(c, e);
        Ap_List.add(app);
    }

    public CalendarDate getAppointment(String name) {
        CalendarDate getterDate = null;
        for(int i = 0; i < Ap_List.size(); i++){
            Appointment app = Ap_List.get(i);

            if(app.getEmployee().getName().equals(name)) {
                getterDate = app.getDate();
            }
        }
        return getterDate;
    }

    public void cancelAppointment(String name){
        for(int i = 0; i < Ap_List.size(); i++){
            Appointment app = Ap_List.get(i);
            if(app.getEmployee().getName().equals(name)) {
                Ap_List.remove(i);
                }
        }
    }

    public String toString(){
        String apps = "";

        for(int i = 0; i < Ap_List.size(); i++){
           apps += Ap_List.get(i).toString();
           apps += "\n";
        }

        return apps;
    }
}
