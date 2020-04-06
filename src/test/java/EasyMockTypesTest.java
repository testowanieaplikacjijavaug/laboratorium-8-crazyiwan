import org.easymock.MockType;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;
public class EasyMockTypesTest {

    @Test
    public void testForDefaultType(){
        ArrayList<Character> list = mock(MockType.DEFAULT, ArrayList.class);
        expect(list.size()).andReturn(3);
        expect(list.add('c')).andReturn(true);
        expect(list.add('d')).andReturn(true);
        expect(list.add('1')).andReturn(true);

        expect(list.get(3)).andReturn(null);

        replay(list);

        assertTrue(list.add('c'));
        assertTrue(list.add('d'));
        assertTrue(list.add('1'));

        assertEquals(3, list.size());

        assertNull(list.get(3));

        verify(list);
    }

    @Test
    public void testForNiceType(){
        ArrayList<Character> list = mock(MockType.NICE, ArrayList.class);
        expect(list.add('c')).andReturn(true);
        expect(list.add('d')).andReturn(true);
        expect(list.size()).andReturn(3);
        expect(list.get(3)).andReturn(null);
        replay(list);

        assertTrue(list.add('c'));
        assertTrue(list.add('d'));

        boolean b = list.add('x');
        assertFalse(b);

        assertEquals(3, list.size());
        assertNull(list.get(3));

        verify(list);
    }

    @Test
    public void testForStrictType(){
        ArrayList<Character> list = mock(MockType.STRICT, ArrayList.class);
        expect(list.add('c')).andReturn(true);
        expect(list.add('d')).andReturn(true);
        expect(list.add('1')).andReturn(true);

        expect(list.size()).andReturn(3);
        expect(list.get(3)).andReturn(null);

        replay(list);

        assertTrue(list.add('c'));
        assertTrue(list.add('d'));
        assertTrue(list.add('1'));

        assertEquals(3, list.size());
        assertNull(list.get(3));

        verify(list);
    }
}
