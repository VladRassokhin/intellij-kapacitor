// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.tickscript.TickScriptElementTypes.*;
import org.intellij.plugins.tickscript.psi.*;

public class TickScriptDurationLiteralImpl extends TickScriptLiteralImpl implements TickScriptDurationLiteral {

  public TickScriptDurationLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TickScriptElementVisitor visitor) {
    visitor.visitDurationLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TickScriptElementVisitor) accept((TickScriptElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getDuration() {
    return findNotNullChildByType(DURATION);
  }

}
