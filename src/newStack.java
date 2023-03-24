import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class newStack {

    private final int INITIAL_SIZE = 16;
    private int position = 0;
    private Object[] elements;

    public newStack() {
        elements = new Object[INITIAL_SIZE];
    }

    public void push(Object e){
        ensureCapacity();
        elements[position++] = e;
    }

    public Object pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object poppedObject = elements[--position];
        elements[position] = null;
        return poppedObject;
    }

    public boolean isEmpty() {
        return position == 0;
    }

    private void ensureCapacity(){
        if (elements.length == position){
            elements = Arrays.copyOf(elements, 2*position+1);
        }
    }


}


