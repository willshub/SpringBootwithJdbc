package org.hegel.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wilsonraphale on 7/3/15.
 */

@RestController
@RequestMapping("user")
public class UserController {
  protected final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserRepository users;

  @RequestMapping("test")
  public String test() {
    log.info("Test");
    return "OK";
  }

  @RequestMapping("user")
  public User getUser(@RequestParam("id") long id) {
    log.info("Get user");
    return users.getUser(id);
  }

  @RequestMapping("users")
  public List<User> getUsers(@RequestParam("ids") long[] ids) {
    log.info("Get users");
    return users.getUsers(ids);
  }

  @RequestMapping(value = "/new/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public long createUser(@PathVariable String username) {
    log.info("Insert user");
    return users.createUser(username);
  }
}
