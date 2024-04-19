package coloti.telescope;

// Functions related to the axis mode ====

/** Axes operational modes. Both the azimuth and elevation axis
 * must be in one of these modes.
 * SHUTDOWN_MODE (brakes on, power off, StowPin extracted)
 * STANDBY_MODE (brakes on, power onStowPin extracted)
 * ENCODER_MODE (brakes on, power on,encoder initialized, position control loop closed)
 * SAFE_STOW_MODE (brakes on, power off,StowPin inserted, position near the horizon)
 * ZENITH_STOW_MODE (brakes on, power off,StowPin inserted, position near the zenith)
 * JOGGING_MODE (brakes on, power on, velocity loop closed)
*/

public enum ETelescopeMountAxisModes {
    Absolute,
    Jogging
}
