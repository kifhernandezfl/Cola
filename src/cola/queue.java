package cola;
import java.io.*;
        
public class queue 
{
    nodo head = null;
	
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
	
    public void  Enqueue(nodo newnodo)
    {
        if(isEmpty())
            head = newnodo;
	else
        {
            nodo temp = head;
            
            while(temp.next != null)
                temp = temp.next;
            
		temp.next = newnodo;
	}
    }
	
    public String Dequeue()
    {
        nodo temp = head;
	head = head.next;
        String info = temp.toString();
	temp = null;
        System.gc();
	return info;
    }
    
    public String Peek()
    {
        nodo temp = head;
	String info = temp.toString();	
        return info;
    }
    
    public void printQueue()
    {	
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
	try
        {   
            bw.write("Grades: \n");
            while(!isEmpty())
		
            bw.write(Dequeue());
			
            bw.flush();
	}
        catch(Exception ex) {ex.printStackTrace();}
    }
    
    public static void main(String[] args) 
    {
        queue cola=new queue();
        cola.Enqueue(new nodo("Hola",1));
        cola.Enqueue(new nodo("Hola1",2));
        cola.Enqueue(new nodo("Hola2",3));
        cola.Enqueue(new nodo("Hola3",4));
        cola.Dequeue();
        
        cola.printQueue();
    }
}