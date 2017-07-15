// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.kapacitor.KapacitorElementTypes.*;
import org.intellij.plugins.kapacitor.psi.*;

public class KapacitorRegexLiteralImpl extends KapacitorLiteralImpl implements KapacitorRegexLiteral {

  public KapacitorRegexLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitRegexLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getRegexString() {
    return findNotNullChildByType(REGEX_STRING);
  }

}
