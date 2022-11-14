package com.se.sample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BasicUser user = BasicUser
                .builder()
                .id(1)
                .name("John Doe")
                .build();

        BasicUserDTO dto = BasicMapper.INSTANCE.convert(user);
        System.out.println( "Hello World!" );
    }
}
