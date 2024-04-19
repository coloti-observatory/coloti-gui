package coloti.telescope;

import coloti.opcua.OpcUaConnector;

public class McsSetters{
private OpcUaConnector mc;
public McsSetters(OpcUaConnector mc) {
	this.mc=mc;
	}
public synchronized void setElServoCoeff1(double val){
	mc.setDoubleValue(EMcsVariables.EL_SERVO_COEFF1,val);
}
public synchronized void setElServoCoeff2(double val){
	mc.setDoubleValue(EMcsVariables.EL_SERVO_COEFF2,val);
}
public synchronized void setWeatherHum(double val){
	mc.setDoubleValue(EMcsVariables.WEATHER_HUM,val);
}
public synchronized void setAzLsECwPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_LS_E_CW_POS,val);
}
public synchronized void setTrajectoryGenerationMode(int val){
	mc.setIntValue(EMcsVariables.TRAJECTORY_GENERATION_MODE,val);
}
public synchronized void setTargetCoordtype(short val){
	mc.setShortValue(EMcsVariables.TARGET_COORDTYPE,val);
}
public synchronized void setAzimuthAbsoluteEncoderOffset(double val){
	mc.setDoubleValue(EMcsVariables.AZIMUTH_ABSOLUTE_ENCODER_OFFSET,val);
}
public synchronized void setAzServoCoeff2(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SERVO_COEFF2,val);
}
public synchronized void setAzServoCoeff1(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SERVO_COEFF1,val);
}
public synchronized void setTargetPx(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_PX,val);
}
public synchronized void setElServoCoeff3(double val){
	mc.setDoubleValue(EMcsVariables.EL_SERVO_COEFF3,val);
}
public synchronized void setAzServoCoeff3(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SERVO_COEFF3,val);
}
public synchronized void setAzTelMinPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_TEL_MIN_POS,val);
}
public synchronized void setAzMaxDec(double val){
	mc.setDoubleValue(EMcsVariables.AZ_MAX_DEC,val);
}
public synchronized void setElLsOLowPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_LS_O_LOW_POS,val);
}
public synchronized void setElMaxDec(double val){
	mc.setDoubleValue(EMcsVariables.EL_MAX_DEC,val);
}
public synchronized void setTpointCoeff23(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF23,val);
}
public synchronized void setAzLsOCwPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_LS_O_CW_POS,val);
}
public synchronized void setTpointCoeff22(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF22,val);
}
public synchronized void setTpointCoeff21(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF21,val);
}
public synchronized void setTpointCoeff20(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF20,val);
}
public synchronized void setWeatherWlen(double val){
	mc.setDoubleValue(EMcsVariables.WEATHER_WLEN,val);
}
public synchronized void setTpointCoeff25(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF25,val);
}
public synchronized void setTpointCoeff24(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF24,val);
}
public synchronized void setTargetEpoch(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_EPOCH,val);
}
public synchronized void setAzLsOCcwPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_LS_O_CCW_POS,val);
}
public synchronized void setElLsPreLowPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_LS_PRE_LOW_POS,val);
}
public synchronized void setElSkyMaxPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_SKY_MAX_POS,val);
}
public synchronized void setTpointCoeff12(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF12,val);
}
public synchronized void setTpointCoeff11(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF11,val);
}
public synchronized void setElSkyMinPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_SKY_MIN_POS,val);
}
public synchronized void setTpointCoeff10(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF10,val);
}
public synchronized void setTpointCoeff16(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF16,val);
}
public synchronized void setTpointCoeff15(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF15,val);
}
public synchronized void setAzSlewAcceleration(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SLEW_ACCELERATION,val);
}
public synchronized void setTpointCoeff14(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF14,val);
}
public synchronized void setTpointCoeff13(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF13,val);
}
public synchronized void setTpointCoeff19(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF19,val);
}
public synchronized void setTpointCoeff18(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF18,val);
}
public synchronized void setAzSlewDeceleration(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SLEW_DECELERATION,val);
}
public synchronized void setTpointCoeff17(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF17,val);
}
public synchronized void setTargetPmRa(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_PM_RA,val);
}
public synchronized void setAzMinAcc(double val){
	mc.setDoubleValue(EMcsVariables.AZ_MIN_ACC,val);
}
public synchronized void setAzPositionTypeSky(boolean val){
	mc.setBooleanValue(EMcsVariables.AZ_POSITION_TYPE_SKY,val);
}
public synchronized void setElMinDec(double val){
	mc.setDoubleValue(EMcsVariables.EL_MIN_DEC,val);
}
public synchronized void setElLsELowPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_LS_E_LOW_POS,val);
}
public synchronized void setElTelMinPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_TEL_MIN_POS,val);
}
public synchronized void setObserverLong(double val){
	mc.setDoubleValue(EMcsVariables.OBSERVER_LONG,val);
}
public synchronized void setElLsOHighPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_LS_O_HIGH_POS,val);
}
public synchronized void setParkingStowPinMode(boolean val){
	mc.setBooleanValue(EMcsVariables.PARKING_STOW_PIN_MODE,val);
}
public synchronized void setElJogVelocity(double val){
	mc.setDoubleValue(EMcsVariables.EL_JOG_VELOCITY,val);
}
public synchronized void setAzimuthIncrementalEncoderOffset(double val){
	mc.setDoubleValue(EMcsVariables.AZIMUTH_INCREMENTAL_ENCODER_OFFSET,val);
}
public synchronized void setResetHeartbeatInterval(int val){
	mc.setIntValue(EMcsVariables.RESET_HEARTBEAT_INTERVAL,val);
}
public synchronized void setDomePosition(double val){
	mc.setDoubleValue(EMcsVariables.DOME_POSITION,val);
}
public synchronized void setAzTelMaxPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_TEL_MAX_POS,val);
}
public synchronized void setOffsetAzimuth(double val){
	mc.setDoubleValue(EMcsVariables.OFFSET_AZIMUTH,val);
}
public synchronized void setTargetPmDec(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_PM_DEC,val);
}
public synchronized void setElSkyPosition(double val){
	mc.setDoubleValue(EMcsVariables.EL_SKY_POSITION,val);
}
public synchronized void setObserverLat(double val){
	mc.setDoubleValue(EMcsVariables.OBSERVER_LAT,val);
}
public synchronized void setIersTaiUtc(double val){
	mc.setDoubleValue(EMcsVariables.IERS_TAI_UTC,val);
}
public synchronized void setAzMinVel(double val){
	mc.setDoubleValue(EMcsVariables.AZ_MIN_VEL,val);
}
public synchronized void setElLsEHighPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_LS_E_HIGH_POS,val);
}
public synchronized void setElTelPosition(double val){
	mc.setDoubleValue(EMcsVariables.EL_TEL_POSITION,val);
}
public synchronized void setAzLsPreCwPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_LS_PRE_CW_POS,val);
}
public synchronized void setTpointCoeff1(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF1,val);
}
public synchronized void setWeatherWidir(double val){
	mc.setDoubleValue(EMcsVariables.WEATHER_WIDIR,val);
}
public synchronized void setTpointCoeff3(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF3,val);
}
public synchronized void setTpointCoeff2(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF2,val);
}
public synchronized void setTpointCoeff5(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF5,val);
}
public synchronized void setTpointCoeff4(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF4,val);
}
public synchronized void setAzLsECcwPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_LS_E_CCW_POS,val);
}
public synchronized void setTpointCoeff7(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF7,val);
}
public synchronized void setTpointCoeff6(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF6,val);
}
public synchronized void setTpointCoeff9(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF9,val);
}
public synchronized void setTrackingDuration(int val){
	mc.setIntValue(EMcsVariables.TRACKING_DURATION,val);
}
public synchronized void setTpointCoeff8(double val){
	mc.setDoubleValue(EMcsVariables.TPOINT_COEFF8,val);
}
public synchronized void setTrackFollowingError(double val){
	mc.setDoubleValue(EMcsVariables.TRACK_FOLLOWING_ERROR,val);
}
public synchronized void setMotionType(int val){
	mc.setIntValue(EMcsVariables.MOTION_TYPE,val);
}
public synchronized void setElevationParkPosition(double val){
	mc.setDoubleValue(EMcsVariables.ELEVATION_PARK_POSITION,val);
}
public synchronized void setTargetEquinox(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_EQUINOX,val);
}
public synchronized void setAzMaxVel(double val){
	mc.setDoubleValue(EMcsVariables.AZ_MAX_VEL,val);
}
public synchronized void setWeatherTemp(double val){
	mc.setDoubleValue(EMcsVariables.WEATHER_TEMP,val);
}
public synchronized void setElSlewDeceleration(double val){
	mc.setDoubleValue(EMcsVariables.EL_SLEW_DECELERATION,val);
}
public synchronized void setAzMaxAcc(double val){
	mc.setDoubleValue(EMcsVariables.AZ_MAX_ACC,val);
}
public synchronized void setElMaxAcc(double val){
	mc.setDoubleValue(EMcsVariables.EL_MAX_ACC,val);
}
public synchronized void setIersXpp(double val){
	mc.setDoubleValue(EMcsVariables.IERS_XPP,val);
}
public synchronized void setAzTelPosition(double val){
	mc.setDoubleValue(EMcsVariables.AZ_TEL_POSITION,val);
}
public synchronized void setAzLsPreCcwPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_LS_PRE_CCW_POS,val);
}
public synchronized void setIersDut1(double val){
	mc.setDoubleValue(EMcsVariables.IERS_DUT1,val);
}
public synchronized void setTargetCoordframe(int val){
	mc.setIntValue(EMcsVariables.TARGET_COORDFRAME,val);
}
public synchronized void setElTelMaxPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_TEL_MAX_POS,val);
}
public synchronized void setWeatherPr(double val){
	mc.setDoubleValue(EMcsVariables.WEATHER_PR,val);
}
public synchronized void setTargetName(String val){
	mc.setStringValue(EMcsVariables.TARGET_NAME,val);
}
public synchronized void setElMinVel(double val){
	mc.setDoubleValue(EMcsVariables.EL_MIN_VEL,val);
}
public synchronized void setElJogDirection(int val){
	mc.setIntValue(EMcsVariables.EL_JOG_DIRECTION,val);
}
public synchronized void setElMaxVel(double val){
	mc.setDoubleValue(EMcsVariables.EL_MAX_VEL,val);
}
public synchronized void setOffsetElevation(double val){
	mc.setDoubleValue(EMcsVariables.OFFSET_ELEVATION,val);
}
public synchronized void setElLsPreHighPos(double val){
	mc.setDoubleValue(EMcsVariables.EL_LS_PRE_HIGH_POS,val);
}
public synchronized void setAzMinDec(double val){
	mc.setDoubleValue(EMcsVariables.AZ_MIN_DEC,val);
}
public synchronized void setAzimuthParkPosition(double val){
	mc.setDoubleValue(EMcsVariables.AZIMUTH_PARK_POSITION,val);
}
public synchronized void setAzSlewVelocity(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SLEW_VELOCITY,val);
}
public synchronized void setElMinAcc(double val){
	mc.setDoubleValue(EMcsVariables.EL_MIN_ACC,val);
}
public synchronized void setTargetRv(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_RV,val);
}
public synchronized void setTargetDec(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_DEC,val);
}
public synchronized void setRefractionOnoff(boolean val){
	mc.setBooleanValue(EMcsVariables.REFRACTION_ONOFF,val);
}
public synchronized void setObserverHe(double val){
	mc.setDoubleValue(EMcsVariables.OBSERVER_HE,val);
}
public synchronized void setElevationObservationLimitMin(double val){
	mc.setDoubleValue(EMcsVariables.ELEVATION_OBSERVATION_LIMIT_MIN,val);
}
public synchronized void setElSlewAcceleration(double val){
	mc.setDoubleValue(EMcsVariables.EL_SLEW_ACCELERATION,val);
}
public synchronized void setIersYpp(double val){
	mc.setDoubleValue(EMcsVariables.IERS_YPP,val);
}
public synchronized void setAzSkyPosition(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SKY_POSITION,val);
}
public synchronized void setPointingModelOnoff(boolean val){
	mc.setBooleanValue(EMcsVariables.POINTING_MODEL_ONOFF,val);
}
public synchronized void setElevationObservationLimitMax(double val){
	mc.setDoubleValue(EMcsVariables.ELEVATION_OBSERVATION_LIMIT_MAX,val);
}
public synchronized void setTargetRa(double val){
	mc.setDoubleValue(EMcsVariables.TARGET_RA,val);
}
public synchronized void setElSlewVelocity(double val){
	mc.setDoubleValue(EMcsVariables.EL_SLEW_VELOCITY,val);
}
public synchronized void setAzJogDirection(int val){
	mc.setIntValue(EMcsVariables.AZ_JOG_DIRECTION,val);
}
public synchronized void setElevationEncoderOffset(double val){
	mc.setDoubleValue(EMcsVariables.ELEVATION_ENCODER_OFFSET,val);
}
public synchronized void setWeatherWi(double val){
	mc.setDoubleValue(EMcsVariables.WEATHER_WI,val);
}
public synchronized void setAzSkyMaxPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SKY_MAX_POS,val);
}
public synchronized void setAzimuthCounterTorque(double val){
	mc.setDoubleValue(EMcsVariables.AZIMUTH_COUNTER_TORQUE,val);
}
public synchronized void setEnableSunAvoidanceWindow(boolean val){
	mc.setBooleanValue(EMcsVariables.ENABLE_SUN_AVOIDANCE_WINDOW,val);
}
public synchronized void setAzSkyMinPos(double val){
	mc.setDoubleValue(EMcsVariables.AZ_SKY_MIN_POS,val);
}
public synchronized void setAzJogVelocity(double val){
	mc.setDoubleValue(EMcsVariables.AZ_JOG_VELOCITY,val);
}
public synchronized void cmdStartPointing(boolean val){
mc.setBooleanValue(EMcsVariables.START_POINTING,val);
}
public synchronized void cmdDomeWest(boolean val){
mc.setBooleanValue(EMcsVariables.DOME_WEST,val);
}
public synchronized void cmdPcShutdown(boolean val){
mc.setBooleanValue(EMcsVariables.PC_SHUTDOWN,val);
}
public synchronized void cmdPcRestart(boolean val){
mc.setBooleanValue(EMcsVariables.PC_RESTART,val);
}
public synchronized void cmdStopMotion(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_MOTION,val);
}
public synchronized void cmdPmcSqmHeaterOn(boolean val){
mc.setBooleanValue(EMcsVariables.PMC_SQM_HEATER_ON,val);
}
public synchronized void cmdStartPointingDome(boolean val){
mc.setBooleanValue(EMcsVariables.START_POINTING_DOME,val);
}
public synchronized void cmdPmcSqmHeaterOff(boolean val){
mc.setBooleanValue(EMcsVariables.PMC_SQM_HEATER_OFF,val);
}
public synchronized void cmdCherenkovOff(boolean val){
mc.setBooleanValue(EMcsVariables.CHERENKOV_OFF,val);
}
public synchronized void cmdResetAlarms(boolean val){
mc.setBooleanValue(EMcsVariables.RESET_ALARMS,val);
}
public synchronized void cmdM2On(boolean val){
mc.setBooleanValue(EMcsVariables.M2_ON,val);
}
public synchronized void cmdStartElMotion(boolean val){
mc.setBooleanValue(EMcsVariables.START_EL_MOTION,val);
}
public synchronized void cmdCherenkovThControlOff(boolean val){
mc.setBooleanValue(EMcsVariables.CHERENKOV_TH_CONTROL_OFF,val);
}
public synchronized void cmdAzStowEmergencyStop(boolean val){
mc.setBooleanValue(EMcsVariables.AZ_STOW_EMERGENCY_STOP,val);
}
public synchronized void cmdStopAzEncInit(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_AZ_ENC_INIT,val);
}
public synchronized void cmdSaveParameters(boolean val){
mc.setBooleanValue(EMcsVariables.SAVE_PARAMETERS,val);
}
public synchronized void cmdAzBrakeOn(boolean val){
mc.setBooleanValue(EMcsVariables.AZ_BRAKE_ON,val);
}
public synchronized void cmdStopParking(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_PARKING,val);
}
public synchronized void cmdUpdateTrajectory(boolean val){
mc.setBooleanValue(EMcsVariables.UPDATE_TRAJECTORY,val);
}
public synchronized void cmdEnableElMotor(boolean val){
mc.setBooleanValue(EMcsVariables.ENABLE_EL_MOTOR,val);
}
public synchronized void cmdSi3Off(boolean val){
mc.setBooleanValue(EMcsVariables.SI3_OFF,val);
}
public synchronized void cmdAzStowOut(boolean val){
mc.setBooleanValue(EMcsVariables.AZ_STOW_OUT,val);
}
public synchronized void cmdElStowEmergencyStop(boolean val){
mc.setBooleanValue(EMcsVariables.EL_STOW_EMERGENCY_STOP,val);
}
public synchronized void cmdDrive400vacOn(boolean val){
mc.setBooleanValue(EMcsVariables.DRIVE_400VAC_ON,val);
}
public synchronized void cmdElStowIn(boolean val){
mc.setBooleanValue(EMcsVariables.EL_STOW_IN,val);
}
public synchronized void cmdStopPointingDome(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_POINTING_DOME,val);
}
public synchronized void cmdUvsipmOn(boolean val){
mc.setBooleanValue(EMcsVariables.UVSIPM_ON,val);
}
public synchronized void cmdCherenkovThControlOn(boolean val){
mc.setBooleanValue(EMcsVariables.CHERENKOV_TH_CONTROL_ON,val);
}
public synchronized void cmdStartAzParking(boolean val){
mc.setBooleanValue(EMcsVariables.START_AZ_PARKING,val);
}
public synchronized void cmdEnableAzMotorResolver(boolean val){
mc.setBooleanValue(EMcsVariables.ENABLE_AZ_MOTOR_RESOLVER,val);
}
public synchronized void cmdStopAzMotion(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_AZ_MOTION,val);
}
public synchronized void cmdCloseDome(boolean val){
mc.setBooleanValue(EMcsVariables.CLOSE_DOME,val);
}
public synchronized void cmdGoOnline(boolean val){
mc.setBooleanValue(EMcsVariables.GO_ONLINE,val);
}
public synchronized void cmdSirenOff(boolean val){
mc.setBooleanValue(EMcsVariables.SIREN_OFF,val);
}
public synchronized void cmdZeroDome(boolean val){
mc.setBooleanValue(EMcsVariables.ZERO_DOME,val);
}
public synchronized void cmdGoLoaded(boolean val){
mc.setBooleanValue(EMcsVariables.GO_LOADED,val);
}
public synchronized void cmdStartTracking(boolean val){
mc.setBooleanValue(EMcsVariables.START_TRACKING,val);
}
public synchronized void cmdElBrakeOff(boolean val){
mc.setBooleanValue(EMcsVariables.EL_BRAKE_OFF,val);
}
public synchronized void cmdEnableAzMotorEncoder(boolean val){
mc.setBooleanValue(EMcsVariables.ENABLE_AZ_MOTOR_ENCODER,val);
}
public synchronized void cmdStopElParking(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_EL_PARKING,val);
}
public synchronized void cmdPmcOn(boolean val){
mc.setBooleanValue(EMcsVariables.PMC_ON,val);
}
public synchronized void cmdElStowOut(boolean val){
mc.setBooleanValue(EMcsVariables.EL_STOW_OUT,val);
}
public synchronized void cmdGoMaintenance(boolean val){
mc.setBooleanValue(EMcsVariables.GO_MAINTENANCE,val);
}
public synchronized void cmdDisableElMotor(boolean val){
mc.setBooleanValue(EMcsVariables.DISABLE_EL_MOTOR,val);
}
public synchronized void cmdStartMotion(boolean val){
mc.setBooleanValue(EMcsVariables.START_MOTION,val);
}
public synchronized void cmdPmcOff(boolean val){
mc.setBooleanValue(EMcsVariables.PMC_OFF,val);
}
public synchronized void cmdStopElMotion(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_EL_MOTION,val);
}
public synchronized void cmdStopTracking(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_TRACKING,val);
}
public synchronized void cmdM2Off(boolean val){
mc.setBooleanValue(EMcsVariables.M2_OFF,val);
}
public synchronized void cmdOpenDome(boolean val){
mc.setBooleanValue(EMcsVariables.OPEN_DOME,val);
}
public synchronized void cmdResetElAxis(boolean val){
mc.setBooleanValue(EMcsVariables.RESET_EL_AXIS,val);
}
public synchronized void cmdEmergencyStop(boolean val){
mc.setBooleanValue(EMcsVariables.EMERGENCY_STOP,val);
}
public synchronized void cmdStartAzEncInit(boolean val){
mc.setBooleanValue(EMcsVariables.START_AZ_ENC_INIT,val);
}
public synchronized void cmdSqmOn(boolean val){
mc.setBooleanValue(EMcsVariables.SQM_ON,val);
}
public synchronized void cmdDisableAzMotorResolver(boolean val){
mc.setBooleanValue(EMcsVariables.DISABLE_AZ_MOTOR_RESOLVER,val);
}
public synchronized void cmdAzStowIn(boolean val){
mc.setBooleanValue(EMcsVariables.AZ_STOW_IN,val);
}
public synchronized void cmdDisableAzMotors(boolean val){
mc.setBooleanValue(EMcsVariables.DISABLE_AZ_MOTORS,val);
}
public synchronized void cmdClearErrorBuffer(boolean val){
mc.setBooleanValue(EMcsVariables.CLEAR_ERROR_BUFFER,val);
}
public synchronized void cmdDomeEast(boolean val){
mc.setBooleanValue(EMcsVariables.DOME_EAST,val);
}
public synchronized void cmdCherenkovOn(boolean val){
mc.setBooleanValue(EMcsVariables.CHERENKOV_ON,val);
}
public synchronized void cmdAzBrakeOff(boolean val){
mc.setBooleanValue(EMcsVariables.AZ_BRAKE_OFF,val);
}
public synchronized void cmdResetAzAxis(boolean val){
mc.setBooleanValue(EMcsVariables.RESET_AZ_AXIS,val);
}
public synchronized void cmdDrive400vacOff(boolean val){
mc.setBooleanValue(EMcsVariables.DRIVE_400VAC_OFF,val);
}
public synchronized void cmdStopAzParking(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_AZ_PARKING,val);
}
public synchronized void cmdEnableAzMotors(boolean val){
mc.setBooleanValue(EMcsVariables.ENABLE_AZ_MOTORS,val);
}
public synchronized void cmdDisableAzMotorEncoder(boolean val){
mc.setBooleanValue(EMcsVariables.DISABLE_AZ_MOTOR_ENCODER,val);
}
public synchronized void cmdStopPointing(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_POINTING,val);
}
public synchronized void cmdUvsipmOff(boolean val){
mc.setBooleanValue(EMcsVariables.UVSIPM_OFF,val);
}
public synchronized void cmdStartElParking(boolean val){
mc.setBooleanValue(EMcsVariables.START_EL_PARKING,val);
}
public synchronized void cmdGoStandby(boolean val){
mc.setBooleanValue(EMcsVariables.GO_STANDBY,val);
}
public synchronized void cmdSqmOff(boolean val){
mc.setBooleanValue(EMcsVariables.SQM_OFF,val);
}
public synchronized void cmdResetParameters(boolean val){
mc.setBooleanValue(EMcsVariables.RESET_PARAMETERS,val);
}
public synchronized void cmdElBrakeOn(boolean val){
mc.setBooleanValue(EMcsVariables.EL_BRAKE_ON,val);
}
public synchronized void cmdStopDome(boolean val){
mc.setBooleanValue(EMcsVariables.STOP_DOME,val);
}
public synchronized void cmdStartParking(boolean val){
mc.setBooleanValue(EMcsVariables.START_PARKING,val);
}
public synchronized void cmdSirenOn(boolean val){
mc.setBooleanValue(EMcsVariables.SIREN_ON,val);
}
public synchronized void cmdSi3On(boolean val){
mc.setBooleanValue(EMcsVariables.SI3_ON,val);
}
public synchronized void cmdStartAzMotion(boolean val){
mc.setBooleanValue(EMcsVariables.START_AZ_MOTION,val);
}
public synchronized void modeModeGoOnline(boolean val){
mc.setBooleanValue(EMcsVariables.MODE_GO_ONLINE,val);
}
public synchronized void modeModeGoLoaded(boolean val){
mc.setBooleanValue(EMcsVariables.MODE_GO_LOADED,val);
}
public synchronized void modeModeGoMaintenance(boolean val){
mc.setBooleanValue(EMcsVariables.MODE_GO_MAINTENANCE,val);
}
public synchronized void modeModeGoStandby(boolean val){
mc.setBooleanValue(EMcsVariables.MODE_GO_STANDBY,val);
}
}