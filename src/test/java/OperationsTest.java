import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.easymock.MockType;
public class OperationsTest {

    @Test
    public void withoutVerifyTest(){
        Operations operations = mock(MockType.NICE, Operations.class);
        expect(operations.getHeight()).andReturn(5);
        expect(operations.getWidth()).andReturn(2);
        replay(operations);

        assertEquals(5, operations.getHeight());

    }

    @Test
    public void withVerifyTest(){
        Operations operations = mock(MockType.NICE, Operations.class);
        expect(operations.getHeight()).andReturn(5);
        expect(operations.getWidth()).andReturn(2);
        replay(operations);

        assertEquals(5, operations.getHeight());

        assertThrows(AssertionError.class, () -> verify(operations));
    }


}
