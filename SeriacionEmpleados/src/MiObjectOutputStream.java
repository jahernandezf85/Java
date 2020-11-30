import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MiObjectOutputStream extends ObjectOutputStream {
	protected MiObjectOutputStream() throws IOException, SecurityException {
		super();
	}
	
	public MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	protected void writeStreamHeader() throws IOException
	{
		
	}
}
