# -*- coding: utf-8 -*-
from CvBuilder import *
createCV = CvBuilder()
createCV.uploadPicture()
createCV.basicInfo()
createCV.summary()
#document.add_heading("Work Experience")
createCV.document.add_heading("Work Experience")
while True:
    hasMoreExperience = input("DO you want to add  experience ? \n Yes|NO\n")
    if hasMoreExperience.lower() == "yes":
        createCV.experience()
    # hackingSkills()
        print("\n")
    else:
        break
createCV.document.add_heading("Projects")

projectDict = {"Mortgage Loan Application":"\nUsed machine learning algorithms to predict and classify credit worthiness.",
               "Staff Promotion Algorithm":"\nPrediction of staff that are likely to be promoted based on defined personal and performance parameters",
               "Facial keypoints Detection System":
            "I implemented a research paper titled Facial Key Points Detection using Deep Convolutional Neural"
            +" Network - NaimishNet.",
            "Landmark-Detection-Tracking-SLAM":"An implementation of SLAM (Simultaneous Localization and Mapping) for a 2-dimensional world! combining"+
            "the knowledge of robot sensor measurements and movement to create a map of an environment from only"+"sensor and motion data gathered by a robot, over time."}
createCV.projects(projectDict)
createCV.saveCV()

"""
By name, I am Victor Adedeji, I'm a Math student and a data scientist with over a year of experience in
Machine Learning and Data Analysis with Python and it's libraries with a basic understanding of web
application. I am a strong believer in teamwork, project management, open-source project and I have a
research interest in Computer Vision.
"""
