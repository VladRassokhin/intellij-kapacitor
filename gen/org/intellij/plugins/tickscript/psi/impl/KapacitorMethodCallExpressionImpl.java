// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.tickscript.KapacitorElementTypes.*;
import org.intellij.plugins.tickscript.psi.*;

public class KapacitorMethodCallExpressionImpl extends KapacitorExpressionImpl implements KapacitorMethodCallExpression {

  public KapacitorMethodCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitMethodCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KapacitorExpression getCallee() {
    return findNotNullChildByClass(KapacitorExpression.class);
  }

}
