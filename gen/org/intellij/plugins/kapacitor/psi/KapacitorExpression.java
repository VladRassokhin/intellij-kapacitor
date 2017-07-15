// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KapacitorExpression extends PsiElement {

  @Nullable
  KapacitorPrimaryFunc getPrimaryFunc();

  @Nullable
  KapacitorStringList getStringList();

  @NotNull
  List<KapacitorChain> getChainList();

  @Nullable
  KapacitorFunction getFunction();

  @Nullable
  KapacitorIdentifier getIdentifier();

  @NotNull
  List<KapacitorLiteral> getLiteralList();

  @Nullable
  KapacitorPrimaryExpr getPrimaryExpr();

  @Nullable
  KapacitorPrimaryUnaryExpr getPrimaryUnaryExpr();

}
