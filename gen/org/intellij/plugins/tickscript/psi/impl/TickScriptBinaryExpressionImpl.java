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
import com.intellij.psi.tree.IElementType;

public class TickScriptBinaryExpressionImpl extends BinaryExpressionMixin implements TickScriptBinaryExpression {

  public TickScriptBinaryExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TickScriptElementVisitor visitor) {
    visitor.visitBinaryExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TickScriptElementVisitor) accept((TickScriptElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TickScriptExpression getLOperand() {
    List<TickScriptExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, TickScriptExpression.class);
    return p1.get(0);
  }

  @Override
  @Nullable
  public TickScriptExpression getROperand() {
    List<TickScriptExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, TickScriptExpression.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

  @NotNull
  public IElementType getOperationSign() {
    return TickScriptPsiImplUtilJ.getOperationSign(this);
  }

}
