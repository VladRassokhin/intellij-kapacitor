// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.tickscript.TickScriptElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.plugins.tickscript.psi.*;

public class TickScriptDeclarationImpl extends ASTWrapperPsiElement implements TickScriptDeclaration {

  public TickScriptDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TickScriptElementVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TickScriptElementVisitor) accept((TickScriptElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TickScriptExpression getValue() {
    List<TickScriptExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, TickScriptExpression.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

  @Override
  public @NotNull TickScriptIdentifier getVariable() {
    return TickScriptPsiImplUtilJ.getVariable(this);
  }

}
