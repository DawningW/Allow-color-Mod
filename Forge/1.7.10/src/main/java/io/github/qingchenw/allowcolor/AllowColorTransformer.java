package dawncraft.qingchenw.allowcolor;

import java.util.Arrays;
import java.util.List;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

public class AllowColorTransformer
  implements IClassTransformer
{
  private static final List CLASSNAMES = Arrays.asList(new String[] { "net.minecraft.util.ChatAllowedCharacters", "v" });
  private static final List METHODNAMES = Arrays.asList(new String[] { "isAllowedCharacter", "func_71566_a", "a" });
  

  public byte[] transform(String name, String transformedName, byte[] basicClass)
  {
    if ((CLASSNAMES.contains(name)) || (CLASSNAMES.contains(transformedName)))
    {
      ClassNode classNode = new ClassNode();
      ClassReader classReader = new ClassReader(basicClass);
      classReader.accept(classNode, 8);
      
      for (MethodNode methodNode : classNode.methods)
      {
        if ((METHODNAMES.contains(methodNode.name)) && (methodNode.desc.equals("(C)Z")))
        {
          methodNode.instructions.remove(methodNode.instructions.get(0));
          methodNode.instructions.remove(methodNode.instructions.get(1));
          methodNode.instructions.remove(methodNode.instructions.get(2));
        }
      }
      
      ClassWriter classWriter = new ClassWriter(2);
      classNode.accept(classWriter);
      return classWriter.toByteArray();
    }
    
    return basicClass;
  }
}
