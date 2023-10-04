import java.util.*;

class Employee {
    private int id;
    private String firstName;
    private String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

 class EmployeeManagement {
    public static void main(String[] args) {
        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "Johnson", "Smith"));
        employeeList.add(new Employee(1, "Kubilay", "Özdemir"));
        employeeList.add(new Employee(3, "Michael", "Jackson"));
        employeeList.add(new Employee(2, "Kubilay", "Özdemir"));
        employeeList.add(new Employee(5,"Alice","Green"));

        LinkedList<Employee> duplicateEmployees = new LinkedList<>();
        Map<Integer, Employee> uniqueEmployeesMap = new HashMap<>();

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (uniqueEmployeesMap.containsKey(employee.hashCode())) {
                duplicateEmployees.add(employee);
                iterator.remove();
            } else {
                uniqueEmployeesMap.put(employee.hashCode(), employee);
            }
        }


        System.out.println("Tekrar eden çalışanlar:");
        for (Employee employee : duplicateEmployees) {
            System.out.println("ID: " + employee.getId() + ", Adı: " + employee.getFirstName() + ", Soyadı: " + employee.getLastName());
        }


        System.out.println("Tekrar etmeyen çalışanlar:");
        for (Employee employee : employeeList) {
            System.out.println("ID: " + employee.getId() + ", Adı: " + employee.getFirstName() + ", Soyadı: " + employee.getLastName());
        }
    }
}
