public class Contact {
    String phone;
    String workPhone;

    public Contact(String phone, String workPhone) {
        this.phone = phone;
        this.workPhone = workPhone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                '}';
    }
}
