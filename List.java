
public class List {
	private class Item {
		GameObject value;
		Item next;
		
		public Item(GameObject value) {
			this(value, null);
		}
		
		public Item(GameObject value, Item next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public class Iterator {
		GameObject curValue;
		Item curNode;
		
		private Iterator(Item startNode) {
			curNode = startNode;
		}
		
		public boolean hasNext() {
			return curNode != null;
		}
		
		public void remove() {
			List.this.remove(curValue);
		}
		
		public GameObject next() {
			curValue = curNode.value;
			curNode = curNode.next;
			return curValue;
		}
	}
	
	private Item first = null;
	
	public void add(GameObject go) {
		if(first == null) {
			first = new Item(go);
		} else {
			first = new Item(go, first);
		}
	}
	
	public void remove(GameObject go) {
		if(first == null) {
			return;
		}
		
		if(first.value.equals(go)) {
			first = first.next;
			return;
		}
		
		Item prev = first;
		for(Item cur = first.next; cur != null; cur = cur.next) {
			if(cur.value.equals(go)) {
				prev.next = cur.next;
				return;
			}
			prev = cur;
		}
	}
	
	public void clear() {
		first = null;
	}
	
	public int size() {
		int count = 0;
		for(Item cur = first; cur != null; cur = cur.next) {
			count++;
		}
		return count;
	}
	
	public Iterator iterator() {
		return new Iterator(first);
	}
}
