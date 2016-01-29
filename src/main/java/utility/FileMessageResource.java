package utility;

import org.springframework.core.io.ByteArrayResource;

/**
 * Created by shafiq on 29/01/16.
 */
public class FileMessageResource extends ByteArrayResource {

    /**
     * The filename to be associated with the message in the form data.
     */
    private final String filename;

    /**
     * Constructs a new message resource
     */
    public FileMessageResource(final byte[] byteArray, final String filename) {
        super(byteArray);
        this.filename = filename;
    }

    @Override
    public String getFilename() {
        return filename;
    }
}