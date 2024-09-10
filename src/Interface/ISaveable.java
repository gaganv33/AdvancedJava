package Interface;

import java.util.List;

public interface ISaveable {
    List<Object> write();
    void read(List<Object> v);
}
