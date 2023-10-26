import com.google.protobuf.InvalidProtocolBufferException;
import de.thi.inf.sesa.simplegrpc.Hello;
import de.thi.inf.sesa.simplegrpc.HelloRequest;
import de.thi.inf.sesa.simplegrpc.HelloResponse;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        HelloRequest request = HelloRequest.newBuilder().setFirstName("Ich").setLastName("Test").build();
        byte[] bytes = request.toByteArray();

        HelloRequest result = HelloRequest.parseFrom(bytes);

    }
}