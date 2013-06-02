/**
 */
package nl.utwente.apc.Code2D.impl;

import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.ControllableObject;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controllable Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ControllableObjectImpl extends MoveableObjectImpl implements ControllableObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ControllableObjectImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Code2DPackage.Literals.CONTROLLABLE_OBJECT;
  }

} //ControllableObjectImpl
