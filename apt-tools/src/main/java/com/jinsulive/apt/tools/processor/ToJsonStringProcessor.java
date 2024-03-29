package com.jinsulive.apt.tools.processor;

import com.jinsulive.apt.tools.annotation.ToJsonString;
import com.jinsulive.apt.tools.util.ToJsonStringUtil;
import com.google.auto.service.AutoService;
import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author lxy
 * @since 2024年03月29日 16:23:40
 */
@AutoService(Processor.class)
public class ToJsonStringProcessor extends AbstractProcessor {

    private Trees trees;
    private TreeMaker maker;
    private Names names;

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(ToJsonString.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        trees = Trees.instance(processingEnv);
        final Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        maker = TreeMaker.instance(context);
        names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(ToJsonString.class);
        for (Element element : elements) {
            JCTree.JCClassDecl jcTreeDecl = (JCTree.JCClassDecl) trees.getTree(element);
            var method = ToJsonStringUtil.genMethod(maker, names, jcTreeDecl);
            jcTreeDecl.defs = jcTreeDecl.defs.append(method);
        }
        return true;
    }

}
