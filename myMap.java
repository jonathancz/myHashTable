/**
	Implementation of own Hash Table with Separate Chaining
	in Java
**/
package HashMaps;
import java.util.ArrayList;

public class Map<K, V> {
	ArrayList<HashNode>>bucket = new ArrayList<>();
	int numBuckets = 10;
	int size;
	public Map() {
		for(int i = 0; i < numBuckets; i++) {
			bucket.add(null);
		}
	}
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private int getBucketIndex(K key) {
		int hashCod = key.hashCode();
		return hashCod % numBuckets;
	}

	public V get(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucket.get(index);
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public V remove(K key)
	{
		int index=getBucketIndex(key);
		HashNode<K, V>head=bucket.get(index);
		if(head==null)
		{
			return null;
		}
		if(head.key.equals(key))
		{
			V val=head.value;
			head=head.next;
			bucket.set(index, head);
			size--;
			return val;
		}
		else
		{
			HashNode<K, V>prev=null;
			while(head!=null)
			{
				
				if(head.key.equals(key))
				{
					prev.next=head.next;
					size--;
					return head.value;
				}
				prev=head;
				head=head.next;
			}
			size--;
			return null;
		}
	}

}