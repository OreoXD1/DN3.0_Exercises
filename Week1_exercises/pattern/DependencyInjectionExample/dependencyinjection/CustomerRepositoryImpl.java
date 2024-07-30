// CustomerRepositoryImpl.java
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulating database lookup
        System.out.println("Finding customer with ID: " + id);
        return new Customer(id, "Purav Jha", "purav.ai@example.com");
    }
}
