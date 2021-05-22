package com.test;

import javax.xml.crypto.dsig.TransformException;

public interface Transformer<I, O>
{
    public O transform(I input) throws TransformException;
}
