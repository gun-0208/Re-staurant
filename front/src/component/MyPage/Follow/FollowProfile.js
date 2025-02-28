import React, { useState } from "react";
import basicimage from "../../../assets/images/user.png";
import styles from "./FollowProfile.module.css";
import Button from "../../UI/Button";
import Navbar from "../../Layout/Navbar";
import FollowPage from "./FollowPage";
import { instance } from "../../../api/axios";
import { FaHeart } from "react-icons/fa";

const FollowProfile = (props) => {
  const [profileimg, setProfileimg] = useState(
    <img alt="img" src={basicimage} width="130px" />
  );

  const [showFollow, setShowFollow] = useState(false);

  const showFollowList = () => {
    setShowFollow(true);
  };

  const followerList = props.user.followerList;
  let followCheck = followerList.find(
    (e) => e.followingEmail === localStorage.getItem("email")
  );

  const updateHandler = () => {
    props.updateHandler();
  };

  const followSubmit = (e) => {
    e.preventDefault();
    const token = localStorage.getItem("accessToken");
    const profile = { followingEmail: props.followEmail };
    instance
      .post("/follow/auth/following", JSON.stringify(profile), {
        headers: { "Content-Type": "application/json", Authorization: token },
      })
      .then((res) => {
        updateHandler();
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div>
      <Navbar />
      <div className={styles.profile}>
        <div className={styles.profileImage}>
          {profileimg}
          <div className={styles.userInfo}>
            <div className={styles.nickname}>
              {props.user.nickname}
              <span
                className={followCheck !== undefined ? styles.followed : styles.notFollowed}
              >
                <Button onClick={followSubmit}>
                  <FaHeart />
                </Button>
              </span>
            </div>
            ({props.user.email})
            <div className={styles.followInfo} onClick={showFollowList}>
              팔로워 {props.user.followerList.length} &nbsp; &nbsp; 팔로잉{" "}
              {props.user.followingList.length}
            </div>
          </div>
        </div>
      </div>
      <div className={styles.grayline}>&nbsp;</div>
      {showFollow ? (
        <FollowPage
          data={props.user}
          closeModal={() => {
            setShowFollow(false);
          }}
        />
      ) : (
        ""
      )}
    </div>
  );
};

export default React.memo(FollowProfile);
