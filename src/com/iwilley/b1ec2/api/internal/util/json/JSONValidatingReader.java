package com.iwilley.b1ec2.api.internal.util.json;

public class JSONValidatingReader extends JSONReader {
    public static final Object INVALID = new Object();
    private JSONValidator validator;
    
    public JSONValidatingReader(JSONValidator validator) {
        this.validator = validator;
    }
    
    public JSONValidatingReader(JSONErrorListener listener) {
        this(new JSONValidator(listener));
    }
    
    public JSONValidatingReader() {
        this(new StdoutStreamErrorListener());
    }

    @Override
	public Object read(String string) {
        if (!validator.validate(string)) return INVALID;
        return super.read(string);
    }
}
