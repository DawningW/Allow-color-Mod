package com.github.qingchenw.allowcolor;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import net.minecraft.launchwrapper.IClassTransformer;


public class AllowColorTransformer implements IClassTransformer
{
	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass)
	{
	    if ("net.minecraft.util.ChatAllowedCharacters".equals(transformedName))
	    {
	    	ClassNode classNode = new ClassNode();
			ClassReader classReader = new ClassReader(basicClass);
			classReader.accept(classNode, ClassReader.EXPAND_FRAMES);
			
			for(MethodNode methodNode : classNode.methods)
			{
				if(methodNode.name.equals("func_71566_a") || methodNode.name.equals("isAllowedCharacter"))
				{
					methodNode.instructions.remove(methodNode.instructions.get(0));
					methodNode.instructions.remove(methodNode.instructions.get(1));
					methodNode.instructions.remove(methodNode.instructions.get(2));
				}
			}
			
			ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			classNode.accept(classWriter);
			return classWriter.toByteArray();
	    }
	    
		return basicClass;
	}
}
