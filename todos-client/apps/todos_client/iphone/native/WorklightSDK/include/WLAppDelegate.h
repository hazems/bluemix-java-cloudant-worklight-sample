/*
 * Licensed Materials - Property of IBM
 * 5725-I43 (C) Copyright IBM Corp. 2013. All Rights Reserved.
 * US Government Users Restricted Rights - Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

//
//  WLAppDelegate.h
//

#pragma mark -
#pragma mark - WL lifecycle events constants
extern NSString *const WLapplicationHandleOpenURL;
extern NSString *const WLapplicationDidReceiveLocalNotification;
extern NSString *const WLapplicationDidRegisterForRemoteNotificationsWithDeviceToken;
extern NSString *const WLapplicationDidFailToRegisterForRemoteNotificationsWithError;
extern NSString *const WLapplicationDidReceiveRemoteNotification;


/**
 * @ingroup hybrid main
 *
 * WLAppDelegate is the base Worklight hybrid application class implementing the <UIApplicationDelegate> protocol.
 * Extending this class allows you to utilize the Worklight framework API.
 */
@interface WLAppDelegate : UIResponder <UIApplicationDelegate>{
    
}

@property (nonatomic, strong) IBOutlet UIWindow* window;

@property (nonatomic, strong) NSMutableDictionary* launchOptions;

@end