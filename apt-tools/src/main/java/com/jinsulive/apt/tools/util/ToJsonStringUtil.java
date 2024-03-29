package com.jinsulive.apt.tools.util;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Names;

import java.util.stream.Collectors;

/**
 * ToJsonString Util
 *
 * @author lxy
 * @since 2024年03月29日 16:34:39
 */
public class ToJsonStringUtil {

    private ToJsonStringUtil() {
    }

    public static JCTree.JCMethodDecl genMethod(TreeMaker maker, Names symbolTable, JCTree.JCClassDecl claz) {
        return maker.at(claz.pos).MethodDef(
                maker.Modifiers(Flags.PUBLIC | Flags.FINAL),
                symbolTable.fromString("toString"),
                maker.Ident(symbolTable.fromString("String")),
                List.nil(),
                List.nil(),
                List.nil(),
                maker.Block(0, makeReturnJsonExpress(maker, symbolTable, claz)), null
        );
    }

    private static List<JCTree.JCStatement> makeReturnJsonExpress(TreeMaker maker, Names name, JCTree.JCClassDecl claz) {
        var json = claz.getMembers().stream().filter(e -> e.getKind() == Tree.Kind.VARIABLE)
                .filter(e -> e instanceof JCTree.JCVariableDecl).map(e -> (JCTree.JCVariableDecl) e).collect(Collectors.toMap(JCTree.JCVariableDecl::getName, JCTree.JCVariableDecl::getType));
        var list = json.entrySet().stream()
                .map(e -> maker.Binary(JCTree.Tag.PLUS, maker.Literal("\"" + e.getKey() + "\":"), processValue(e.getValue(), e.getKey(), maker, name)))
                .reduce((e1, e2) -> maker.Binary(JCTree.Tag.PLUS, e1, maker.Binary(JCTree.Tag.PLUS, maker.Literal(","), e2)))
                .orElseThrow();
        list = maker.Binary(JCTree.Tag.PLUS, maker.Literal("{"), list);
        list = maker.Binary(JCTree.Tag.PLUS, list, maker.Literal("}"));
        return List.of(maker.Return(
                list
        ));
    }

    private static JCTree.JCExpression processValue(JCTree value, Name name, TreeMaker maker, Names names) {
        var typeName = value.toString();
        switch (typeName) {
            case "List<String>":
            case "List<CharSequence>":
            case "Collection<CharSequence>":
            case "Collection<String>":
            case "Set<CharSequence>":
            case "Set<String>":
            case "Queue<CharSequence>":
            case "Queue<String>":
            case "String":
            case "CharSequence":
            case "StringBuilder":
            case "StringBuffer":
                var toS = maker.Exec(maker.Apply(
                        List.nil(),
                        maker.Select(
                                maker.Ident(name),
                                names.fromString("toString")
                        ),
                        List.nil()
                ));
                var replaced = maker.Exec(
                        maker.Apply(
                                List.nil(),
                                maker.Select(
                                        toS.expr,
                                        names.fromString("replaceAll")
                                ),
                                List.of(
                                        maker.Literal("\\\""),
                                        maker.Literal("\\\\\"")
                                )
                        )
                );
                return maker.Binary(JCTree.Tag.PLUS, maker.Literal("\""),
                        maker.Binary(JCTree.Tag.PLUS, replaced.expr, maker.Literal("\"")));
            default:
                return maker.Ident(name);
        }
    }

}
