var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');
var Opcodes = Java.type('org.objectweb.asm.Opcodes');

function initializeCoreMod() {
    return {
        'AllowColorTransformer': {
            'target': {
                'type': 'CLASS',
                'name': 'net/minecraft/SharedConstants'
            },
            'transformer': function (classNode) {
                classNode.methods.forEach(function (methodNode) {
                    if (methodNode.name.equals("m_136188_") || methodNode.name.equals("isAllowedChatCharacter")) {
                        methodNode.instructions.remove(methodNode.instructions.get(0));
                        methodNode.instructions.remove(methodNode.instructions.get(1));
                        methodNode.instructions.remove(methodNode.instructions.get(2));
                    }
                });
                return classNode;
            }
        }
    };
}
