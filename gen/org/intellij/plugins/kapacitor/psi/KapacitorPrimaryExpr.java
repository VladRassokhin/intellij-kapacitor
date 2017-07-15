// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KapacitorPrimaryExpr extends KapacitorExpression {

  @NotNull
  List<KapacitorPrimaryFunc> getPrimaryFuncList();

  @NotNull
  List<KapacitorIdentifier> getIdentifierList();

  @NotNull
  List<KapacitorPrimaryExpr> getPrimaryExprList();

  @NotNull
  List<KapacitorPrimaryUnaryExpr> getPrimaryUnaryExprList();

}
