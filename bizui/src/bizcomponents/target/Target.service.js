import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}targetManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}targetManager/loadTarget/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProfile = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}targetManager/requestCandidateProfile/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProfile = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}targetManager/transferToAnotherProfile/id/anotherProfileId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBanner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}targetManager/requestCandidateBanner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBanner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}targetManager/transferToAnotherBanner/id/anotherBannerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const TargetService = { view,
  load,
  requestCandidateProfile,
  requestCandidateBanner,
  transferToAnotherProfile,
  transferToAnotherBanner }
export default TargetService

