package org.jngine.net.serialize;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import org.junit.Test;

import junit.framework.TestCase;

public class ProtostuffTest extends TestCase{

	@Test
	public void test(){
		
		Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
		
		Person person = new Person();
		person.id = 1;
		person.name = "abc";
		person.email = "def";
		
		LinkedBuffer buffer = LinkedBuffer.allocate(1024);
		
		byte[] data = ProtobufIOUtil.toByteArray(person, schema, buffer);
		
		Person person1 = new Person();
		ProtobufIOUtil.mergeFrom(data, person1, schema);
		
		assertEquals(person, person1);
		assertEquals(person1.id, 1);
	}
}
