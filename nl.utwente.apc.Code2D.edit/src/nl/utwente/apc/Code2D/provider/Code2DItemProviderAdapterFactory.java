/**
 */
package nl.utwente.apc.Code2D.provider;

import java.util.ArrayList;
import java.util.Collection;

import nl.utwente.apc.Code2D.util.Code2DAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Code2DItemProviderAdapterFactory extends Code2DAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Code2DItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Game} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameItemProvider gameItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Game}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGameAdapter() {
		if (gameItemProvider == null) {
			gameItemProvider = new GameItemProvider(this);
		}

		return gameItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Player} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayerItemProvider playerItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Player}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlayerAdapter() {
		if (playerItemProvider == null) {
			playerItemProvider = new PlayerItemProvider(this);
		}

		return playerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.NPC} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NPCItemProvider npcItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.NPC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNPCAdapter() {
		if (npcItemProvider == null) {
			npcItemProvider = new NPCItemProvider(this);
		}

		return npcItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Item} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemItemProvider itemItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Item}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createItemAdapter() {
		if (itemItemProvider == null) {
			itemItemProvider = new ItemItemProvider(this);
		}

		return itemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.World} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorldItemProvider worldItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.World}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorldAdapter() {
		if (worldItemProvider == null) {
			worldItemProvider = new WorldItemProvider(this);
		}

		return worldItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Terrain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerrainItemProvider terrainItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Terrain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTerrainAdapter() {
		if (terrainItemProvider == null) {
			terrainItemProvider = new TerrainItemProvider(this);
		}

		return terrainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Trap} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrapItemProvider trapItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Trap}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTrapAdapter() {
		if (trapItemProvider == null) {
			trapItemProvider = new TrapItemProvider(this);
		}

		return trapItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Scenery} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SceneryItemProvider sceneryItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Scenery}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSceneryAdapter() {
		if (sceneryItemProvider == null) {
			sceneryItemProvider = new SceneryItemProvider(this);
		}

		return sceneryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Instance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceItemProvider instanceItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Instance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceAdapter() {
		if (instanceItemProvider == null) {
			instanceItemProvider = new InstanceItemProvider(this);
		}

		return instanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.Event} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventItemProvider eventItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.Event}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventAdapter() {
		if (eventItemProvider == null) {
			eventItemProvider = new EventItemProvider(this);
		}

		return eventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.AddToInventoryAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddToInventoryActionItemProvider addToInventoryActionItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.AddToInventoryAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddToInventoryActionAdapter() {
		if (addToInventoryActionItemProvider == null) {
			addToInventoryActionItemProvider = new AddToInventoryActionItemProvider(this);
		}

		return addToInventoryActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.BasicAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicActionItemProvider basicActionItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.BasicAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBasicActionAdapter() {
		if (basicActionItemProvider == null) {
			basicActionItemProvider = new BasicActionItemProvider(this);
		}

		return basicActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.utwente.apc.Code2D.CollisionTrigger} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollisionTriggerItemProvider collisionTriggerItemProvider;

	/**
	 * This creates an adapter for a {@link nl.utwente.apc.Code2D.CollisionTrigger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCollisionTriggerAdapter() {
		if (collisionTriggerItemProvider == null) {
			collisionTriggerItemProvider = new CollisionTriggerItemProvider(this);
		}

		return collisionTriggerItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (gameItemProvider != null) gameItemProvider.dispose();
		if (playerItemProvider != null) playerItemProvider.dispose();
		if (npcItemProvider != null) npcItemProvider.dispose();
		if (itemItemProvider != null) itemItemProvider.dispose();
		if (worldItemProvider != null) worldItemProvider.dispose();
		if (terrainItemProvider != null) terrainItemProvider.dispose();
		if (trapItemProvider != null) trapItemProvider.dispose();
		if (sceneryItemProvider != null) sceneryItemProvider.dispose();
		if (instanceItemProvider != null) instanceItemProvider.dispose();
		if (eventItemProvider != null) eventItemProvider.dispose();
		if (addToInventoryActionItemProvider != null) addToInventoryActionItemProvider.dispose();
		if (basicActionItemProvider != null) basicActionItemProvider.dispose();
		if (collisionTriggerItemProvider != null) collisionTriggerItemProvider.dispose();
	}

}
