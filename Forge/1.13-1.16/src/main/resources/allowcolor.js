// 使用Java.type，类似import
var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');
var Opcodes = Java.type('org.objectweb.asm.Opcodes');

function initializeCoreMod() {
    return {
        'AllowColorTransformer': {
            'target': {
                'type': 'CLASS',
                'name': 'net/minecraft/util/SharedConstants'
                // net.minecraft.client.gui.GuiUtilRenderComponents.removeTextColorsIfConfigured
            },
            'transformer': function (classNode) {
                // 遍历ClassNode下的methods
                classNode.methods.forEach(function (methodNode) {
                    // boolean isAllowedCharacter(char)
                    // ASMAPI.mapMethod(methodNode.name).equals("func_71566_a") && methodNode.desc.equals("(C)Z")
                    if (methodNode.name.equals("func_71566_a") || methodNode.name.equals("isAllowedCharacter")) {
                        methodNode.instructions.remove(methodNode.instructions.get(0));
                        methodNode.instructions.remove(methodNode.instructions.get(1));
                        methodNode.instructions.remove(methodNode.instructions.get(2));
                    }
                });
                // 返回修改后的ClassNode对象
                return classNode;
            }
        }
    };
}
