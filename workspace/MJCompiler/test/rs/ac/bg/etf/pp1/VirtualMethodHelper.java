package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.extensions.ExtendedStruct;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;

import java.util.ArrayList;
import java.util.HashSet;

public final class VirtualMethodHelper {
    private VirtualMethodHelper() {}

    private static ArrayList<Byte> methodTable = new ArrayList<>();

    private static void addWordToStaticData (int value, int address) {
        methodTable.add((byte) Code.const_);
        methodTable.add((byte) (value >> 24));
        methodTable.add((byte) (value >> 16));
        methodTable.add((byte) (value >> 8));
        methodTable.add((byte) value);
        methodTable.add((byte) Code.putstatic);
        methodTable.add((byte) (address >> 8));
        methodTable.add((byte) address);
    }

    private static void addNameTerminator() {
        addWordToStaticData(-1, Code.dataSize++);
    }

    private static void addTableTerminator() {
        addWordToStaticData(-2, Code.dataSize++);
    }

    private static void addFunctionAddress(int functionAddress) {
        addWordToStaticData(functionAddress, Code.dataSize++);
    }

    private static void addFunctionEntry(String name, int functionAddressInCodeBuffer) {
        for (int j=0; j<name.length(); j++)
        {
            addWordToStaticData((int)(name.charAt(j)), Code.dataSize++);
        }
        addNameTerminator();
        addFunctionAddress(functionAddressInCodeBuffer);
    }

    public static void putClass(ExtendedStruct classStruct) {
        HashSet<String> alreadyAdded = new HashSet<>();

        ExtendedStruct curr = classStruct;

        while (curr != null) {
            curr.getMembers().symbols().forEach(objectNode -> {
                if (objectNode.getKind() == Obj.Meth) {
                    if (!alreadyAdded.contains(objectNode.getName())) {
                        addFunctionEntry(objectNode.getName(), objectNode.getAdr());
                        alreadyAdded.add(objectNode.getName());
                    }
                }
            });

            curr = curr.getParent();
        }

        addTableTerminator();
    }

    public static ArrayList<Byte> getMethodTable() {
        return methodTable;
    }

    public static void resetMethodTable() {
        methodTable = new ArrayList<>();
    }
}
