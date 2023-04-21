import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private DataCell<E> cell = new DataCell<>();

    private DataCell<E> getCell(int index) {
        DataCell<E> result;
        if (size == 1) {
            return cell;
        } else {
            int counter = 1;
            result = cell;
            while (counter < index) {
                result = result.next;
                counter++;
            }
        }
        return result;
    }

    public void add(E value) {
        if (size == 0) {
            cell.setElement(value);
            size++;
        } else {
            cell.addElement(value);
            size++;
        }
    }

    public int size() {
        return size;
    }

    private DataCell<E> cellCounter(int index) {
        int counter = 0;
        DataCell<E> res = cell;
        while (counter < index) {
            res = res.next;
            counter++;
        }
        return res;
    }

    public E getByIndex(int index) {
        if (index > size) {
            return null;
        } else {
            DataCell<E> result = cellCounter(index);
            return result.getElement();
        }
    }

    public E getNextByIndex(int index) {
        if (index >= size - 1) {
            return null;
        } else {
            DataCell<E> result = cellCounter(index);
            return result.next.getElement();
        }
    }

    public E getPreviousByIndex(int index) {
        if (index > size  || index == 0) {
            return null;
        } else {
            DataCell<E> result = cellCounter(index);
            return result.previous.getElement();
        }
    }

    public void replaceByIndex(int index, E value) {
        DataCell<E> temp = cellCounter(index);
        temp.setElement(value);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            DataCell<E> current = cell;
            boolean isFirst = true;

            @Override
            public boolean hasNext() {
                if (size == 1 && isFirst) {
                    return true;
                }
                return current.isNext();
            }

            @Override
            public E next() {
                if (isFirst) {
                    isFirst = false;
                } else {
                    current = current.next;
                }
                return current.getElement();
            }
        };
    }

    private class DataCell<E> {
        private E element;
        private DataCell<E> next;
        private DataCell<E> previous;

        DataCell() {
            this.element = null;
            this.next = null;
            this.previous = null;
        }

        DataCell(E value) {
            this.element = value;
            this.next = null;
            this.previous = (DataCell<E>) getCell(size);
        }

        void setElement(E value) {
            element = value;
        }

        E getElement() {
            return element;
        }

        boolean isNext() {
            return next != null;
        }

        void addElement(E value) {
            if (isNext()) {
                next.addElement(value);
            } else {
                next = new DataCell<>(value);
            }
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}