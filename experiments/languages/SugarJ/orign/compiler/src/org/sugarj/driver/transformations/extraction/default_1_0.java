package org.sugarj.driver.transformations.extraction;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class default_1_0 extends Strategy 
{ 
  public static default_1_0 instance = new default_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_26)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("default_1_0");
    Fail207:
    { 
      IStrategoTerm h_137 = null;
      IStrategoTerm g_137 = null;
      if(term.getTermType() != IStrategoTerm.APPL || ext_out._consdefault_1 != ((IStrategoAppl)term).getConstructor())
        break Fail207;
      g_137 = term.getSubterm(0);
      IStrategoList annos171 = term.getAnnotations();
      h_137 = annos171;
      term = t_26.invoke(context, g_137);
      if(term == null)
        break Fail207;
      term = termFactory.annotateTerm(termFactory.makeAppl(ext_out._consdefault_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, h_137));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}